$(
    function addEventHandlers() {
        $("a.up, a.down").click(
            function handleClick() {
                var currentElement = $(this);
                var header = $("meta[name='_csrf_header']").attr("content");
                var token = $("meta[name='_csrf']").attr("content");

                var questionId = currentElement.parent().parent().prop("id"); // question_1234
                var id = questionId.substring(questionId.indexOf("_") + 1); // 1234
                if ($.inArray("selectedUp", currentElement.attr("class").split(/\s+/)) !== -1
                            || $.inArray("selectedDown", currentElement.attr("class").split(/\s+/)) !== -1) {
                    $.ajax({
                        url: "vote/" + id,
                        type: "DELETE",
                        beforeSend: function(xhr){
                            xhr.setRequestHeader(header, token);
                        },
                        success: function (data) {
                            currentElement.removeClass("selectedUp selectedDown");
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            console.log("Delete vote failed!");
                            // TODO: redirect to login page if error vode 500 or 403 (invalid CSRF)
                        }
                    });
                }
                else {
                    var vote;
                    if ($.inArray("up", currentElement.attr("class").split(/\s+/)) !== -1) {
                        vote = "up";
                    }
                    else { // down
                        vote = "down";
                    }

                    $.ajax({
                        url: "vote/" + id + "/" + vote,
                        type: "POST",
                        beforeSend: function(xhr){
                            xhr.setRequestHeader(header, token);
                        },
                        success: function (data) {
                            currentElement.addClass("selected" + vote.substring(0, 1).toUpperCase() + vote.substring(1));
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            console.log("Voting failed!");
                            // TODO: redirect to login page if error vode 500 or 403 (invalid CSRF)
                        }
                    });
                }
            }
        );
    }
);
