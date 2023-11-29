const music= new Audio('vande.mp3');

let masterplay = document.getElementById('masterPlay');
masterplay.addEventListener('click',()=>{
    if (music.paused || music.currentTime <=0){
        music.play();
        masterplay.classList.remove('bi bi-play-fill');
        masterplay.classList.add('')
    }
})
