package com.chao.dao;

import com.chao.po.Article;

public interface DeleteImp {

    /**
     * 假性删除文档，
     * 即7天内可在回收站复原
     * @param article
     */
    void deleteArticleFake(Article article);

    /**
     * 真正删除文档，不可复原
     * 该方法在回收站中被调用
     * @param article
     */
    void deleteArticleTrue(Article article);

    /**
     * 删除收藏的文档
     * @param article
     */
    void deleteFavorite(Article article);
}
