package afkt.accessibility.ui.activity

import afkt.accessibility.R
import afkt.accessibility.service.AccessibilityListenerService
import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import dev.utils.app.ActivityUtils
import dev.utils.app.IntentUtils
import dev.utils.app.toast.ToastUtils

/**
 * detail:
 * @author Ttt
 * <pre>
 *     具体代码 copy Github ActivityTracker 库
 *     @see <a href="https://github.com/fashare2015/ActivityTracker"/>
 *     <p></p>
 *     内部只是封装 AccessibilityListenerService 以及 BaseApplication 结合 DevApp#AccessibilityUtils 使用
 *     可自行实现其他功能模块, 例如微信抢红包、自动点击等操作
 * </pre>
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    // = View =

//    @JvmField
//    @BindView(R.id.vid_am_drawer_layout)
//    var vid_am_drawer_layout: DrawerLayout? = null

    // = Object =

    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        checkOverlayPermission()
    }

    // ===========
    // = OnClick =
    // ===========

    @OnClick(R.id.vid_am_activity_tracker_btn)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.vid_am_activity_tracker_btn -> {
                if (AccessibilityListenerService.checkAccessibility()) {
                    startService(
                        Intent(this@MainActivity, AccessibilityListenerService::class.java)
                            .putExtra(
                                AccessibilityListenerService.COMMAND,
                                AccessibilityListenerService.COMMAND_OPEN
                            )
                    )
                    ActivityUtils.startHomeActivity()
                } else {
                    ToastUtils.showLong(R.string.str_open_accessibility_tips)
                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && !Settings.canDrawOverlays(this)) {
            checkOverlayPermission()
        }
    }

    private fun checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                startActivityForResult(
                    IntentUtils.getManageOverlayPermissionIntent(),
                    REQUEST_CODE
                )
                ToastUtils.showLong(R.string.str_open_floating_tips)
            }
        }
    }
}