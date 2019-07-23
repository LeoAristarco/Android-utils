package fusap.com.runity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.view.inputmethod.InputMethodManager


fun Activity.showToastShort(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.showToastLong(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun ViewGroup.inflate(layoutId:Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}


fun FragmentActivity.closeKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
}


fun FragmentActivity.changeFragmentFromUseCase(fragment: Fragment, containerViewId: Int) {
    supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    changeFragment(fragment, containerViewId, true)
}

fun FragmentActivity.changeFragment(fragmentToChange: Fragment, containerViewId: Int, stack: Boolean) {
    closeKeyboard()

    val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragmentToChange)
    if (stack) {
        fragmentTransaction.addToBackStack(null)
    }
    fragmentTransaction.commit()
}

fun <T> FragmentActivity.changeActivity(clazz: Class<T>) {
    val intent = Intent(this, clazz)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
    startActivity(intent)
    this.finish()
}

