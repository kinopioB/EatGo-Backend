package com.kinopio.eatgo.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kinopio.eatgo.store.dao.StoreDao;
import com.kinopio.eatgo.store.dto.MenuRequestDto;
import com.kinopio.eatgo.store.dto.OpenInfoRequestDto;
import com.kinopio.eatgo.store.dto.PopularStoreResponseDto;
import com.kinopio.eatgo.store.dto.ReviewRequestDto;
import com.kinopio.eatgo.store.dto.ReviewResponseDto;
import com.kinopio.eatgo.store.dto.StoreDetailResponseDto;
import com.kinopio.eatgo.store.dto.StoreDto;
import com.kinopio.eatgo.store.dto.StoreHistoryRequestDto;
import com.kinopio.eatgo.store.dto.StoreModificationResponseDto;
import com.kinopio.eatgo.store.dto.StoreMyPageResponseDto;
import com.kinopio.eatgo.store.dto.StoreRequestDto;
import com.kinopio.eatgo.store.dto.StoreResponseDto;
import com.kinopio.eatgo.store.dto.StoreSimpleResponseDto;
import com.kinopio.eatgo.store.dto.StoreStatusRequestDto;
import com.kinopio.eatgo.store.dto.StoreSummaryResponseDto;
import com.kinopio.eatgo.store.dto.TagRequestDto;
import com.kinopio.eatgo.store.dto.TodayOpenStoreResponseDto;
import com.kinopio.eatgo.store.entity.Menu;
import com.kinopio.eatgo.store.entity.OpenInfo;
import com.kinopio.eatgo.store.entity.Tag;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

	private final StoreDao storeDao;

	@Override
	public List<StoreSimpleResponseDto> getAllStores() {
		return storeDao.selectAllStore();
	}

	@Override
	public Boolean createReview(ReviewRequestDto reviewRequestDto) {
		try {
			storeDao.insertReview(reviewRequestDto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ReviewResponseDto> getAllStoreReviews(int storeId) {
		return storeDao.selectStoreReviews(storeId);
	}

	@Override
	public List<StoreSimpleResponseDto> getCategoryStores(int categoryId) {
		return storeDao.selectCategoryStores(categoryId);
	}

	@Override
	public List<StoreSimpleResponseDto> getTagStores(String tagName) {
		return storeDao.selectTagStores(tagName);
	}

	@Override
	public StoreResponseDto getStore(int storeId) {
		StoreResponseDto storeSummary = storeDao.selectStore(storeId);
		storeSummary.setRatingAverage(storeDao.selectStoreAverageRating(storeId));
		log.info(storeSummary);
		return storeSummary;
	}

	@Override
	public StoreDetailResponseDto getStoreDetail(int storeId) {
		StoreDetailResponseDto storeDetail = storeDao.selectStoreDetailById(storeId);
		Float avg = storeDao.selectStoreAverageRating(storeId);
		
		if (avg == null) {
			avg = 0.0f;
		}
		
		storeDetail.setRatingAverage(avg);
		
		return storeDetail;
	}

	@Transactional
	@Override
	public Integer createStore(StoreRequestDto storeRequestDto) {
		try {

			StoreDto storeDto = StoreDto.builder().storeName(storeRequestDto.getStoreName())
					.userId(storeRequestDto.getUserId()).address(storeRequestDto.getAddress())
					.positionX(storeRequestDto.getPositionX()).positionY(storeRequestDto.getPositionY())
					.categoryId(storeRequestDto.getCategoryId()).createdType(storeRequestDto.getCreatedType()).build();
			storeDto = storeDao.insertStore(storeDto);
			if (storeDto.getStoreId() == null) {
				throw new Exception();
			}

			//log.info("store Created {} ", storeDto);
			// 메뉴 생성 -> insert
			List<Menu> menus = new ArrayList<Menu>();

			for (MenuRequestDto menu : storeRequestDto.getMenus()) {
				Menu menuItem = Menu.builder().storeId(storeDto.getStoreId()).menuName(menu.getMenuName())
						.price(menu.getPrice()).amount(menu.getAmount()).thumbnail(menu.getThumbnail())
						.isBest(menu.getIsBest()).build();

				menus.add(menuItem);
			}

			//메뉴가 있는 경우 삽입
			if(menus.size()!=0) {
				if (storeDao.insertMenus(menus) < menus.size()) {
					throw new Exception("메뉴 등록에 실패하였습니다.");
				}

				log.info("menus Inserted {} ", menus);
			}
			
			
			
			List<Tag> tags = new ArrayList<Tag>();
			for (TagRequestDto tag : storeRequestDto.getTags()) {
				Tag tagItem = Tag.builder().storeId(storeDto.getStoreId()).tagName(tag.getTagName()).build();
				tags.add(tagItem);
			}

			// 태그가 있는 경우 삽입
			if(tags.size()!=0) {
				if (storeDao.insertTags(tags) < tags.size()) {
					throw new Exception("태그 등록에 실패하였습니다.");
				}
			}
			
			
			List<OpenInfo> openInfos = new ArrayList<OpenInfo>();
			for (OpenInfoRequestDto openInfo : storeRequestDto.getOpenInfos()) {
				OpenInfo openInfoItem = OpenInfo.builder().storeId(storeDto.getStoreId()).day(openInfo.getDay())
						.openTime(openInfo.getOpenTime()).closeTime(openInfo.getCloseTime()).build();
				openInfos.add(openInfoItem);
			}
			
			// 영업일 정보가 있는 경우 
			if(openInfos.size()!=0) {
				if (storeDao.insertOpenInfos(openInfos) < openInfos.size()) {
					throw new Exception("영업 정보 등록에 실패하였습니다.");
				}
			}
	

//			// 리턴할 정보 -> 추후 논의 후 변경 
			StoreDetailResponseDto storeDetailResponseDto = StoreDetailResponseDto.builder()
					.storeId(storeDto.getStoreId()).storeName(storeDto.getStoreName()).address(storeDto.getAddress())
					.positionX(storeDto.getPositionX()).positionY(storeDto.getPositionY()).isOpen(0)
					.createdType(storeDto.getCreatedType()).createdAt(storeDto.getCreatedAt())
					.userId(storeDto.getUserId()).categoryId(storeDto.getCategoryId()).tags(tags).menus(menus)
					.openInfos(openInfos).build();

			return storeDto.getStoreId();
			

		} catch (Exception e) {
			log.info(e.getMessage());
			return -1;
		}
	}

	@Override
	public Boolean changeStoreStatusOpen(StoreHistoryRequestDto storeHistoryRequestDto) {
		// TODO Auto-generated method stub
		try {
			if (storeDao.updateStoreOpenStatus(storeHistoryRequestDto) < 1) {
				throw new Exception("영업 시작 업데이트에 실패하였습니다.");
			}
			if (storeDao.insertStoreHistory(storeHistoryRequestDto) < 1) {
				throw new Exception("영업 정보 이력 등록에 실패하였습니다.");
			}
			return true;
		} catch (Exception e) {
			log.info("영업 시작 등록 실패 ");
			log.info(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean changeStoreStatusClose(int storeId) {
		try {
			if (storeDao.updateStoreCloseStatus(storeId) < 1) {
				throw new Exception("영업 종료 업데이트에 실패하였습니다.");
			}
			return true;
		} catch (Exception e) {
			log.info("영업 종료 등록 실패 ");
			log.info(e.getMessage());
			return false;
		}
	}

	@Override
	public List<StoreSimpleResponseDto> getFilterStores(String searchFilter) {
		return storeDao.selectFilterStore(searchFilter);
	}

	@Override
	public List<PopularStoreResponseDto> getPopularStores() {
		return storeDao.selectPopularStores();
	}

	@Override
	public List<TodayOpenStoreResponseDto> getTodayOpenStores() {
		return storeDao.selectTodayOpenStores();
	}

	@Override
	public StoreMyPageResponseDto getStoreMyPage(int storeId) {
		StoreMyPageResponseDto storeMyPageResponseDto = storeDao.selectStoreMyPage(storeId);
		storeMyPageResponseDto.setRatingAverage(storeDao.selectStoreAverageRating(storeId));
		storeMyPageResponseDto.setReviewNum(storeDao.selectReviewCount(storeId));
		log.info("service : {}", storeMyPageResponseDto);
		
		return storeMyPageResponseDto;
		
	}

	@Override
	public StoreModificationResponseDto getModificationStoreMyPage(int storeId) {
		return storeDao.selectStoreModificationMyPage(storeId);
	}
	
	
}
