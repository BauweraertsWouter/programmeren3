$(document).ready(function() {
    $("td.subject").click(
        function () {
            var id = $(this).parent().attr('id');
            console.log("click!" + id);
        }
    );
});
