document.addEventListener('DOMContentLoaded', function() {
    var searchInput = document.getElementById('searchInput');
    var searchResultsContainer = document.getElementById('searchResultsContainer');

    searchInput.addEventListener('input', function() {
        var query = searchInput.value.trim();
        if (query.length === 0) {
            searchResultsContainer.innerHTML = '';
            return;
        }
        searchSongs(query);
    });
});

function searchSongs(query) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/songs/search?query=' + encodeURIComponent(query), true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                displaySearchResults(response);
            } else {
                console.error('Error al realizar la solicitud: ' + xhr.status);
            }
        }
    };
    xhr.send();
}

function displaySearchResults(results) {
    var searchResultsContainer = document.getElementById('searchResultsContainer');
    searchResultsContainer.innerHTML = '';

    if (results.length === 0) {
        searchResultsContainer.innerHTML = '<p>No se encontraron resultados</p>';
    } else {
        var ul = document.createElement('ul');
        results.forEach(function(song) {
            var li = document.createElement('li');
            li.textContent = song.title + ' - ' + song.artist;
            ul.appendChild(li);
        });
        searchResultsContainer.appendChild(ul);
    }
    function showMemoryForm(songId) {
        $('#songId').val(songId); // Set the selected song ID in the hidden input field
        $('#memoryFormModal').modal('show');
    }

    }

