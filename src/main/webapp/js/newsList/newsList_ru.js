$(document).ready(function () {

    $('#newsForm').validate({ // initialize the plugin
        rules: {
            'selectedItems': {
                required: true
            }
        },
        messages: {
            'selectedItems': {
                required: "Отметьте хотя бы одну новость для удаления"
            }
        },
        submitHandler: function(form) {
            if (confirm('Вы действительно хотите удалить выбранные новости?')) {
                form.submit();
            }
        },
        errorPlacement: function (error, element) {
            alert(error.text());
        }

    });

});