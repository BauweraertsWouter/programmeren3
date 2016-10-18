$(
    function addEventHandlers() {
        $("a.up, a.down").click(
            function handleClick() {
                // AJAX call
                console.log("Logging: " + this);
            }
        );
    }
);
