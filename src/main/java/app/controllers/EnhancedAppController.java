package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.common.Util;

public abstract class EnhancedAppController extends AppController {

    protected boolean isHtmx() {
        return !Util.blank(header("HX-Request"));
    }

    protected void hxLocation(String url) {
        header("HX-Location", url);
    }

    protected void hxRedirect(String url) {
        header("HX-Redirect", url);
    }

    protected void hxPush(String url) {
        header("HX-Push", url);
    }

    protected void hxRefresh() {
        header("HX-Refresh", "true");
    }

    protected void hxTrigger(String eventName) {
        header("HX-Trigger", eventName);
    }

    protected void hxTriggerAfterSwap(String eventName) {
        header("HX-Trigger-After-Swap", eventName);
    }


}
