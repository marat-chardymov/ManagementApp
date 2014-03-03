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
            if (confirm('Are you sure?')) {
                form.submit();
            }
        },
        errorPlacement: function (error, element) {
            alert(error.text());
        }

    });

});