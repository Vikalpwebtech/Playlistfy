package Playlistfy_Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Album a1 = new Album("Punjabi Songs","Siddhu Mossewala");
        a1.addNewSongToAlbum("Old Skool",4.0);
        a1.addNewSongToAlbum("Legend",5.0);
        a1.addNewSongToAlbum("Dhaka",6.0);
        a1.addNewSongToAlbum("Cheque",6.0);

        Album a2 = new Album("Hindi Song","Akhil Sachdeva");
        a2.addNewSongToAlbum("Dil Shagna",6.0);
        a2.addNewSongToAlbum("Madhainya",3.0);
        a2.addNewSongToAlbum("Rata Lambiya",5.0);
        a2.addNewSongToAlbum("Apna Bnale",4.0);
        //Now adding songs to playList from different album
        ArrayList<Song> playList = new ArrayList<>();
        //Since we defined this function in Album
        a1.addSongToPlayList(1,playList);
        a1.addSongToPlayList(2,playList);

        //Now from album 2
        a2.addSongToPlayList(3,playList);
        a2.addSongToPlayList(4,playList);
        play(playList);
    }

    public static void ShuffleAndPrintRandomSongFromPL(ArrayList<Song> playList){
        if(playList.isEmpty()){
            System.out.println("The PlayList is Empty ,please add some song to it");
            return;
        }
        //Generate a random index within the size ArrayList
        //Use the object of predefined Random class
        Random  random = new Random();
        //This function will generate a randow index
        int randomindex = random.nextInt(playList.size());
        System.out.println(playList.get(randomindex).getTitle().toString());
    }
    public static void play(ArrayList<Song> playList){
        printMenu();
        System.out.println("Now Playing");
        int currIndex = 0;
        System.out.println(playList.get(currIndex).toString());
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        boolean isOver = false;

        while (isOver ==false){
            switch (choice){
                case 1:
                    if(currIndex == playList.size() - 1){
                        System.out.println("You are already at the Last Song");
                    }
                    else{
                        currIndex++;
                        System.out.println(playList.get(currIndex).toString());
                    }
                    break;
                case 2:
                    if(currIndex == 0){
                        System.out.println("You are already at the First Song");
                    }
                    else{
                        currIndex--;
                        System.out.println(playList.get(currIndex).toString());
                    }
                    break;
                case 3:
                    System.out.println(playList.get(currIndex).toString());
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    PrintAllSongs(playList);
                    break;
                case 6:
                    isOver = true;
                    break;
                case 7:
                    //print random song from the playList
                    ShuffleAndPrintRandomSongFromPL(playList);
                    break;
                case 8:
                    //Add song from playList of only one particular artist
                    System.out.println("Enter the Artist Name whose song you want to hear in a loop");
                    String artistname = sc.nextLine();
                    ArrayList<Song> songlist = new ArrayList<>();
                    //fetch songs of artist from different album
                    break;
            }
            choice = sc.nextInt();
        }
    }
    public static void PrintAllSongs(ArrayList<Song> playList){
        for(Song song:playList){
            System.out.println(song.getTitle());
        }
    }
    public static void printMenu(){
        System.out.println("Enter your choice");
        System.out.println("1. Go to Next Song");
        System.out.println("2. Go to Previous Song");
        System.out.println("3. Repeat the Song");
        System.out.println("4. Print the Menu Again");
        System.out.println("5. Print PlayList");
        System.out.println("6. Close the System");
        System.out.println("7. Play random song from the PlayList");
        System.out.println("8. Play song of any one Artist");
    }
}