$(document).ready(function () {

    $('#newsForm').validate({ // initialize the plugin
        rules: {
            'selectedItems': {
                required: true
            }
        },
        messages: {
            'selectedItems': {
                required: newsList.atLeastOne
            }
        },
        submitHandler: function(form) {
            if (confirm(newsList.deleteConfirm)) {
                form.submit();
            }
        },
        errorPlacement: function (error, element) {
            alert(error.text());
        }

    });

});
