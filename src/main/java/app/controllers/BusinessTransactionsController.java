package app.controllers;

import app.models.BusinessTransaction;
import org.javalite.activejdbc.Paginator;
import org.javalite.activeweb.annotations.RESTful;
import org.javalite.common.Convert;

import java.util.Optional;

import static org.javalite.app_config.AppConfig.p;

@RESTful
public class BusinessTransactionsController extends EnhancedAppController {

    @HTMX("business_transactions_list.ftl")
    public void index() {
        Integer pageSize = Convert.toInteger(p("page_size"));
        Integer page = Optional.ofNullable(Convert.toInteger(param("page"))).orElse(1);

        Paginator<BusinessTransaction> paginator = Paginator.<BusinessTransaction>instance().pageSize(pageSize)
                .modelClass(BusinessTransaction.class)
                .countQuery("*")
                .query("*")
                .currentPageIndex(page, true)
                .create();
        view("transactions", paginator.getPage());
        view("total_page", paginator.getCount());
        view("current_page", page);
    }

    public void newForm() {

    }


}
