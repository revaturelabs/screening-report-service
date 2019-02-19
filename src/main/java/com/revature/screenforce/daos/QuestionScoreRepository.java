package com.revature.screenforce.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.QuestionScore;

import java.util.List;

/**
 * The DAO for Question Score.
 *
 * @author Thomas Santillan| 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@Repository
public interface QuestionScoreRepository extends JpaRepository<QuestionScore, Integer> {

	/**
	 * Finds question scores containing given screening id
	 *
	 * @param screeningId Id of Screening
	 * @return List of question scores
	 */
	List<QuestionScore> findAllByScreeningScreeningId(int screeningId);
	List<QuestionScore> findAllByBucketId(int bucketId);
}
