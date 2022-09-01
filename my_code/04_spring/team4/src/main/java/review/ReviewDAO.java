package review;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("review_dao")
public class ReviewDAO {
	
	@Autowired
	SqlSession session;
	
	public int registertReview(ReviewDTO dto) {
		return session.insert("registerReview", dto);
	}
	
//	public void updateReview(ReviewDTO dto) {
//		session.update("updateReview", dto);
//	}
}
