$(
    function addEventHandlers() {
        $("a.up, a.down").click(
            function handleClick(event) {
                event.preventDefault();

                var currentElement = $(this);
                var header = $("meta[name='_csrf_header']").attr("content");
                var token = $("meta[name='_csrf']").attr("content");
                var scoreSpanElement = currentElement.siblings("span")[0];

                var vote;
                if ($.inArray("up", currentElement.attr("class").split(/\s+/)) !== -1) {
                    vote = "up";
                }
                else { // down
                    vote = "down";
                }

                var questionId = currentElement.parent().parent().prop("id"); // question_1234 or answer_1234
                var id = questionId.substring(questionId.indexOf("_") + 1); // 1234
                if ($.inArray("selectedUp", currentElement.attr("class").split(/\s+/)) !== -1
                            || $.inArray("selectedDown", currentElement.attr("class").split(/\s+/)) !== -1) {
                    $.ajax({
                        url: "/vote/" + id,
                        type: "DELETE",
                        beforeSend: function(xhr){
                            xhr.setRequestHeader(header, token);
                        },
                        success: function (data) {
                            currentElement.removeClass("selectedUp selectedDown");
                            if (vote === "up") {
                                $(scoreSpanElement).text(parseInt($(scoreSpanElement).text()) - 1);
                            }
                            else {
                                $(scoreSpanElement).text(parseInt($(scoreSpanElement).text()) + 1);
                            }
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            if (xhr.status == 403 || xhr.status == 500) {
                                window.location.href = "/login";
                            }
                        }
                    });
                }
                else {
                    var selectedSiblings = currentElement.siblings(".selectedUp, .selectedDown");
                    $.ajax({
                        url: "/vote/" + id + "/" + vote,
                        type: "POST",
                        beforeSend: function(xhr){
                            xhr.setRequestHeader(header, token);
                        },
                        success: function (data) {
                            currentElement.addClass("selected" + vote.substring(0, 1).toUpperCase() + vote.substring(1));
                            var amountOfVotesToAddOrRemove;
                            if (selectedSiblings.length === 1) {
                                amountOfVotesToAddOrRemove = 2;
                            }
                            else {
                                amountOfVotesToAddOrRemove = 1;
                            }

                            if (vote === "up") {
                                $(scoreSpanElement).text(parseInt($(scoreSpanElement).text()) + amountOfVotesToAddOrRemove);
                            }
                            else {
                                $(scoreSpanElement).text(parseInt($(scoreSpanElement).text()) - amountOfVotesToAddOrRemove);
                            }

                            // Remove the selectedXXX class from any siblings that may have it.
                            if (selectedSiblings.length === 1) {
                                $(selectedSiblings[0]).removeClass("selectedUp selectedDown");
                            }
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            if (xhr.status == 403 || xhr.status == 500) {
                                window.location.href = "/login";
                            }
                        }
                    });
                }
            }
        );
    }
);
