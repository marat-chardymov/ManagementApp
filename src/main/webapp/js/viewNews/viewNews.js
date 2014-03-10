$('#deleteBtn').on('click', function () {
    if (confirm(viewNews.deleteConfirm)) {
        document.location = 'NewsAction.do?action=delete';
    }
});
$('#editBtn').on('click', function () {
    document.location = 'NewsAction.do?action=edit';
});