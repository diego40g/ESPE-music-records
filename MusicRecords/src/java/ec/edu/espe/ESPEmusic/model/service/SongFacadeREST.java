/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model.service;

import ec.edu.espe.ESPEmusic.connection.Querys;
import ec.edu.espe.ESPEmusic.model.Band;
import ec.edu.espe.ESPEmusic.model.Song;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Pc
 */
@Stateless
@Path("song-recordMusic")
public class SongFacadeREST{// extends AbstractFacade<Cancion> {

    Querys query = new  Querys();
    
    @GET
    @Path("allSong")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Song> getAllSong() {
        return query.allSong();
    }
    
    @GET
    @Path("songByBand/{band}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Song> getMembersByBand(@PathParam("band") String band) {
        return query.songByNameBand(band);
    }
    
    @GET
    @Path("bandBySong/{song}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<String> getBandBySong(@PathParam("song") String song) {
        return query.bandBySong(song);
    }
    
//    @PersistenceContext(unitName = "ESPE-record-musicPU")
//    private EntityManager em;
//
//    private SongPK getPrimaryKey(PathSegment pathSegment) {
//        /*
//         * pathSemgent represents a URI path segment and any associated matrix parameters.
//         * URI path part is supposed to be in form of 'somePath;codigoMusico=codigoMusicoValue;codigoBanda=codigoBandaValue;codigoCancion=codigoCancionValue'.
//         * Here 'somePath' is a result of getPath() method invocation and
//         * it is ignored in the following code.
//         * Matrix parameters are used as field names to build a primary key instance.
//         */
//        ec.edu.espe.ESPEmusic.model.SongPK key = new ec.edu.espe.ESPEmusic.model.SongPK();
//        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
//        java.util.List<String> codigoMusico = map.get("codigoMusico");
//        if (codigoMusico != null && !codigoMusico.isEmpty()) {
//            key.setCodigoMusico(codigoMusico.get(0));
//        }
//        java.util.List<String> codigoBanda = map.get("codigoBanda");
//        if (codigoBanda != null && !codigoBanda.isEmpty()) {
//            key.setCodigoBanda(codigoBanda.get(0));
//        }
//        java.util.List<String> codigoCancion = map.get("codigoCancion");
//        if (codigoCancion != null && !codigoCancion.isEmpty()) {
//            key.setCodigoCancion(codigoCancion.get(0));
//        }
//        return key;
//    }
//
//    public SongFacadeREST() {
//        super(Song.class);
//    }
//
//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Song entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") PathSegment id, Song entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") PathSegment id) {
//        ec.edu.espe.ESPEmusic.model.SongPK key = getPrimaryKey(id);
//        super.remove(super.find(key));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Song find(@PathParam("id") PathSegment id) {
//        ec.edu.espe.ESPEmusic.model.SongPK key = getPrimaryKey(id);
//        return super.find(key);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Cancion> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Cancion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
//    
}
