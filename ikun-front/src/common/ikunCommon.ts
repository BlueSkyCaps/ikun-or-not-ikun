
export function playAudio(url:string){
    const player = new Audio(url);
    player.play().then(r => console.log(r));
}
