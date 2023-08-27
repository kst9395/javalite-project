<@content for="title">Login</@>

<div class="container p-4">

    <@form controller="auth" method="POST" action="login">
        <div class="field">
            <label class="label" for="username">Username</label>
            <input type="text" id="username" class="input" placeholder="Username"/>
        </div>
        <div class="field">
            <label class="label" for="password">Password</label>
            <input type="password" id="password" class="input" placeholder="********" />
        </div>
        <button class="button is-primary" type="submit">Login</button>
        <button class="button is-default" type="reset">Clear</button>
    </@>

</div>