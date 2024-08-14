package com.tzion.jetpackmovies.domain.posters.pager

//@OptIn(ExperimentalPagingApi::class)
//class MovieRemoteMediator(
//    private val query: String,
//    private val cache: DataGateway,
//    private val network: RemoteFacade
//) : RemoteMediator<Int, Movie.Information>() {
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, Movie.Information>
//    ): MediatorResult {
//        val loadKey = when (loadType) {
//            LoadType.REFRESH -> null
//            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
//            LoadType.APPEND -> {
//                val lastItem = state.lastItemOrNull()
//                if (lastItem == null) {
//                    return MediatorResult.Success(
//                        endOfPaginationReached = true
//                    )
//                }
//                lastItem.title
//            }
//        }
////        val posters = network.findMoviePostersByName(name = query)
////        cache.saveAllPosters(posters)
//    }
//}