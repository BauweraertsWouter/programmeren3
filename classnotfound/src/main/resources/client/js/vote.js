$(
    function addEventHandlers() {
        $("a.up").click(
            function handleClick() {
                var id = $(this).parent().parent().prop("id"); // question_1234
                $.post("vote/" + id.substring(id.indexOf("_") + 1) + "/up")
                    .done(function (data) {
                        alert("Data Loaded: " + data);
                    });
            }
        );

        $("a.down").click(
            function handleClick() {
                var id = $(this).parent().parent().prop("id"); // question_1234
                $.post("vote/" + id.substring(id.indexOf("_") + 1) + "/down")
                    .done(function (data) {
                        alert("Data Loaded: " + data);
                    });
            }
        );
    }
);
