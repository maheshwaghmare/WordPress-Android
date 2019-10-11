package org.wordpress.android.ui.uploads

import android.content.Context
import org.wordpress.android.fluxc.model.MediaModel
import org.wordpress.android.fluxc.model.PostModel
import org.wordpress.android.fluxc.model.SiteModel
import java.util.ArrayList
import javax.inject.Inject

/**
 * An injectable class built on top of [UploadService].
 *
 * The main purpose of this is to provide testability for classes that use [UploadService]. This should never
 * contain any static methods.
 */
class UploadServiceFacade @Inject constructor(private val appContext: Context) {
    fun uploadPost(post: PostModel, trackAnalytics: Boolean) {
        val intent = UploadService.getRetryUploadServiceIntent(appContext, post, trackAnalytics)
        appContext.startService(intent)
    }

    fun isPostUploadingOrQueued(post: PostModel) = UploadService.isPostUploadingOrQueued(post)

    fun getPendingOrInProgressFeaturedImageUploadForPost(postModel: PostModel) =
            UploadService.getPendingOrInProgressFeaturedImageUploadForPost(postModel)

    fun uploadMedia(mediaList: ArrayList<MediaModel>) =
            UploadService.uploadMedia(appContext, mediaList)

    fun cancelFinalNotification(post: PostModel) =
            UploadService.cancelFinalNotification(appContext, post)

    fun cancelFinalNotificationForMedia(site: SiteModel) =
            UploadService.cancelFinalNotificationForMedia(appContext, site)
}
