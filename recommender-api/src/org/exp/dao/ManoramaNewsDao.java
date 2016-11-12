package org.exp.dao;

import org.exp.dto.ManoramaDto;
import org.exp.entity.ManoramaNews;

public interface ManoramaNewsDao {

	public Long addManoramaNews(ManoramaNews manoramaNews);

	public String getManoramaNewsID(Long newsId);

	public ManoramaDto getRecommedNews(String articleID);

}
