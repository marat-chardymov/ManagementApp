$(document).ready(function () {

    $('#newsForm').validate({ // initialize the plugin
        rules: {
            'selectedItems': {
                required: true
            }
        },
        messages: {
            'selectedItems': {
                required: "You must check at least 1 news to delete"
            }
        },
        submitHandler: function(form) {
            if (confirm('Do you really want to delete these news?')) {
                form.submit();
            }
        },
        errorPlacement: function (error, element) {
            alert(error.text());
        }

    });

});