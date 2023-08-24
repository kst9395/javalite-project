<@content for="title">Business transactions</@content>

<div class="box mt-2 is-flex is-flex-direction-column">
    <header class="is-flex is-align-items-center is-justify-content-space-between">
        <h1 class="has-text-weight-bold flex-grow-1">All transactions</h1>
        <#if total_page!=0>
            <span class="flex-grow-0 ">Total page ${total_page!0}</span>
        </#if>
    </header>
    <main class="is-flex is-flex-direction-column" >
        <div class="py-2">
        <button class="is-primary button">New</button>
        </div>
        <#if transactions?has_content>
        <@render partial="/htmx/business_transaction_card" collection=transactions/>
        <#else>
        <span class="has-text-weight-light">
            No transaction found
        </span>
        </#if>
    </main>
    <#if total_page!=0>
    <footer>

    </footer>
    </#if>
</div>