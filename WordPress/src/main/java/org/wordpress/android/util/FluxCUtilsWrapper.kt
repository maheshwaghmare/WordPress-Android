package org.wordpress.android.util

import android.content.Context
import android.net.Uri
import dagger.Reusable
import org.wordpress.android.fluxc.store.MediaStore
import javax.inject.Inject

/**
 * Injectable wrapper around FluxCUtils.
 *
 * FluxCUtils interface is consisted of static methods, which make the client code difficult to test/mock.
 * Main purpose of this wrapper is to make testing easier.
 *
 */
@Reusable
class FluxCUtilsWrapper @Inject constructor(private val appContext: Context) {
    fun mediaModelFromLocalUri(uri: Uri, mimeType: String?, mediaStore: MediaStore, localSiteId: Int)
            = FluxCUtils.mediaModelFromLocalUri(appContext, uri, mimeType, mediaStore, localSiteId)
}