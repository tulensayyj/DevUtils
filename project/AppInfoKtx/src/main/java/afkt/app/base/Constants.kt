package afkt.app.base

/**
 * detail: 常量
 * @author Ttt
 */
class Constants {

    object Key {

        // 包名
        const val KEY_PACKNAME = "packName"

        // APK 地址
        const val KEY_APK_URI = "apkUri"

        // 应用排序
        const val KEY_APP_SORT = "appSort"

        // 搜索后缀
        const val KEY_QUERY_SUFFIX = "querySuffix"

        // 传值
        const val KEY_VALUE = "value"
    }

    object Notify {

        private const val BASE = 1000

        // 查询 APP 列表结束通知
        const val H_QUERY_APPLIST_END_NOTIFY = BASE + 1

        // 查询 手机参数 结束通知
        const val H_QUERY_DEVICE_INFO_END_NOTIFY = BASE + 2

        // 导出设备信息通知
        const val H_EXPORT_DEVICE_MSG_NOTIFY = BASE + 3

        // 导出 APP 信息通知
        const val H_EXPORT_APP_MSG_NOTIFY = BASE + 4

        // 导出应用 APK 安装包通知
        const val H_EXPORT_APP_NOTIFY = BASE + 5

        // 应用排序变更
        const val H_APP_SORT_NOTIFY = BASE + 6

        // 搜索合并通知
        const val H_SEARCH_COLLAPSE = BASE + 7

        // 搜索展开通知
        const val H_SEARCH_EXPAND = BASE + 8

        // 搜索输入内容通知
        const val H_SEARCH_INPUT_CONTENT = BASE + 9

        // 切换 Fragment 通知
        const val H_TOGGLE_FRAGMENT_NOTIFY = BASE + 10

        // 搜索文件资源结束通知
        const val H_QUERY_FILE_RES_END_NOTIFY = BASE + 11

        // 搜索文件资源中通知
        const val H_QUERY_FILE_RES_ING_NOTIFY = BASE + 12

        // 刷新通知
        const val H_REFRESH_NOTIFY = BASE + 13

        // 删除文件通知
        const val H_DELETE_APK_FILE_NOTIFY = BASE + 14
    }

    object RequestCode {

        private const val BASE = 3000

        // 跳转 App 详情页面 回传
        const val FOR_R_APP_DETAILS = BASE + 1

        // 卸载 App 回传
        const val FOR_R_APP_UNINSTALL = BASE + 2
    }
}