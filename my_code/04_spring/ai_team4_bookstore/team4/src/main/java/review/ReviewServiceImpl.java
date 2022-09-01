package review;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("review_service")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	@Qualifier("review_dao")
	ReviewDAO dao;

	@Override
	public int registerReview(ReviewDTO dto) {
		return dao.registertReview(dto);
	}

//	@Override
//	public void updateReview(ReviewDTO dto) {
//		dao.updateReview(dto);
//		
//	}
}
