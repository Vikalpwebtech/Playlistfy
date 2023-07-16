package Playlistfy_Application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artistname;
    private List<Song> songList;

    public Album(String name, String artistname) {
        this.name = name;
        this.artistname = artistname;
        this.songList = new ArrayList<>();
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getArtistname() {
        return artistname;
    }

    public boolean FindSongByTitle(String title){
        for(Song song:songList){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addNewSongToAlbum(String title,double duration){
        if(FindSongByTitle(title)){
            return "The Following Song Already Exists";
        }
        //Now if not exists
        Song newsong = new Song(title,duration);
        this.songList.add(newsong);
        return "Song has been successfully Added";
    }
    public String addSongToPlayList(int songNo, ArrayList<Song> playList){
        //Need to find the index
        int index = songNo - 1;
        if(index >= 0 && index < songList.size()){
            Song song = songList.get(index);
            playList.add(song);
            return "Song added to playList successfully";
        }
        else{
            return "Enter a Valid Song Number";
        }


    }
}
