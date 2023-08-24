<!doctype html>
<html>
    <head>
        <title><@yield to="title"/></title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    </head>
    <body>
    <div class="is-flex is-flex-direction-column is-align-item-flex-start is-justify-content-flex-start" style="height:100vh">
        <nav class="navbar has-shadow is-color-white" role="navigation">
            <div class="navbar-brand">
                <span class="navbar-item is-size-4">
                    Intranet
                </span>
            </div>
            <div class="navbar-menu">
                <div class="navbar-start">
                    <@link_to controller="home" class="navbar-item">Home</@>
                    <@link_to controller="business_transactions" class="navbar-item">Business Transactions</@>
                </div>
                <div class="navbar-end">
                    <a href="#" class="navbar-item">Login</a>
                </div>
            </div>
        </nav>
        <div class="is-flex-grow-1">
            <div class="container">
            ${page_content}
            </div>
        </div>
    </div>
    <script src="https://unpkg.com/htmx.org@1.9.4" integrity="sha384-zUfuhFKKZCbHTY6aRR46gxiqszMk5tcHjsVFxnUo8VMus4kHGVdIYVbOYYNlKmHV" crossorigin="anonymous"></script>
    </body>
</html>