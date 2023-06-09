package Mytunes.DAL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.DAL.DAO.CatogriesDAO;
import Mytunes.DAL.DAO.PlaylistDAO;
import Mytunes.DAL.DAO.SongDAO;
import Mytunes.DAL.database.DbConnector;
import Mytunes.DAL.fakeDAO.Fake_PlaylistDAO;
import Mytunes.DAL.fakeDAO.Fake_SongDAO;

import java.sql.SQLException;
import java.util.List;

public class DALManager implements IDALManager {

    private DbConnector connector;
    private SongDAO songDAO;
    private PlaylistDAO playlistDAO;
    private CatogriesDAO catogriesDAO;

    private Fake_SongDAO fakeSongDAO;
    private Fake_PlaylistDAO fakePlaylistDAO;

    public DALManager() {
        this.fakeSongDAO = new Fake_SongDAO();
        this.fakePlaylistDAO = new Fake_PlaylistDAO();

      /*  try {
           // this.connector = new DbConnector();
           // this.playlistDAO = new PlaylistDAO(connector.getConnection());
           // this.songDAO = new SongDAO(connector.getConnection());
        } catch (SQLServerException e) {
            e.printStackTrace();
        } */
    }

    @Override
    public List<Song> getAllSongs() throws SQLException {
        return songDAO.getAllSongs();
    }



    @Override
    public Song createSong(Song song) throws SQLException {
       return songDAO.createSong(song);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return fakePlaylistDAO.getAllPlaylists();
    }

    @Override
    public Playlist createPlaylist(String name) {
        return fakePlaylistDAO.createPlaylist(name);
    }

    public void deleteSong(Song song){
        fakeSongDAO.deleteSong(song);
    }

    public void deletePlaylist(Playlist playlist){
        fakePlaylistDAO.deletePlaylist(playlist);
    }

    public List<Song> getSongsFromPlaylist(Playlist playlist){
        return fakePlaylistDAO.getSongsFromPlaylist(playlist);
    }


}

