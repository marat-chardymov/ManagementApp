$(document).ready(function () {

    $('#newsForm').validate({ // initialize the plugin
        rules: {
            'selectedItems': {
                required: true,
                maxlength: 2
            }
        },
        messages: {
            'selectedItems': {
                required: "You must check at least 1 news to delete",
                maxlength: "Check no more than {0} boxes"
            }
        },
        submitHandler: function(form) {
            if (confirm('are you sure?')) {
                form.submit();
            }
        },
        errorPlacement: function (error, element) {
            alert(error.text());
        }

    });

});