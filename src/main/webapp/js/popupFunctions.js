function ReportGame(game_id, game_url , game_name, game_description) {
    document.getElementById("gameInfoID").innerText = "ID: " + game_id;
    document.getElementById("gameURL").src = game_url;
    document.getElementById("gameName").innerText = game_name;
    document.getElementById("gameDescription").innerText = game_description;
    document.getElementById('id04').style.display='block';
}

function AddGame() {
    document.getElementById('id03').style.display='block';
}

function EditGame(game_id, game_url , game_name, game_description) {
    document.getElementById("updateID").value = game_id;
    document.getElementById("editGameID").innerText = "Edit Game ID: " + game_id;
    document.getElementById("updateURl").value = game_url;
    document.getElementById("updateName").value = game_name;
    document.getElementById("updateDescription").innerText = game_description;
    document.getElementById("id01").style.display='block';
}

function AreYouSure(game_id) {
    document.getElementById("delquestion").innerText = "Are you sure you want to delete ID : " + game_id;
    document.getElementById("deleteID").value = game_id;
    document.getElementById('id02').style.display='block';
}

