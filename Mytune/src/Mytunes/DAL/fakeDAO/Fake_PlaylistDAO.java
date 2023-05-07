package Mytunes.DAL.fakeDAO;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;

import java.util.ArrayList;
import java.util.List;

public class Fake_PlaylistDAO {
    private List<Playlist> fakeDB = new ArrayList<>();

    public Fake_PlaylistDAO() {
        Playlist playlist1 = new Playlist(1, "playlist1");
        Playlist playlist2 = new Playlist(2, "testPlaylist2");
        Playlist playlist3 = new Playlist(3, "testPlaylist3");

        playlist1.addSong(new Song(10,"testing1", "no idea", Category.Rap, 511,""));

        playlist2.addSong(new Song(10,"testing2", "no idea", Category.Rap, 511,""));
        playlist2.addSong(new Song(20,"testing3", "no idea", Category.Rap, 511, ""));

        playlist3.addSong(new Song(10,"testing4", "no idea",Category.Rap, 511, ""));
        playlist3.addSong(new Song(20,"testing5", "no idea", Category.Rap, 511, ""));
        playlist3.addSong(new Song(30,"testing6", "no idea", Category.Rap, 511, ""));

        fakeDB.add(playlist1);
        fakeDB.add(playlist2);
        fakeDB.add(playlist3);
    }


    public List<Playlist> getAllPlaylists() {
        return fakeDB;
    }

    public Playlist createPlaylist(String name) {
        Playlist newPlaylist = new Playlist(fakeDB.size() + 1, name);
        fakeDB.add(newPlaylist);
        return newPlaylist;
    }

    public void deletePlaylist(Playlist playlist){
        fakeDB.remove(playlist);
    }
    public List<Song> getSongsFromPlaylist(Playlist playlist){
        return playlist.getSongList();
    }

    //public Playlist getThePlaylist(Playlist playlistToShow){
      //  return playlistToShow;
    //}
}
