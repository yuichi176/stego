package com.movies.stegobe.app.internal_v1.form

import kotlin.math.max
import kotlin.math.min

/**
 * 映画投稿検索パラメータ
 */
data class MovieSearchParam(
    val user_id: Int?,
    val p: Int? = null,
    val rc: Int? = null,
    val s: String? = null
) {
    companion object {
        const val LIMIT_MAX = 100
    }

    /** ページ番号を返す関数 */
    private fun getPage(): Int = if (p == null) 1 else max(p, 1)

    /** 表示件数を返す関数 */
    fun getLimit(): Int = if (rc == null) 100 else max(min(rc, LIMIT_MAX), 0)

    /** オフセットを返す関数 */
    fun getOffset(): Int = getLimit() * (getPage() -1)
}
