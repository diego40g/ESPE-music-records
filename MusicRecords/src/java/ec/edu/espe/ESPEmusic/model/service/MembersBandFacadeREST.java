/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model.service;

import ec.edu.espe.ESPEmusic.connection.Querys;
import ec.edu.espe.ESPEmusic.model.MembersBand;
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

/**
 *
 * @author Pc
 */
@Stateless
@Path("membersBand-recordMusic")
public class MembersBandFacadeREST{// extends AbstractFacade<MiembrosBanda> {
    
    Querys query = new  Querys();
    
    @GET
    @Path("allMembers")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MembersBand> getAllMembers() {
        return query.allMembersBand();
    }
    
    @GET
    @Path("membersByBand/{band}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MembersBand> getMembersByBand(@PathParam("band") String band) {
        return query.membersOfBand(band);
    }
    
    @GET
    @Path("membersInstrument/{position}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<MembersBand> getMembersPosition(@PathParam("position") String position) {
        return query.membersPosition(position);
    }
//    @PersistenceContext(unitName = "ESPE-record-musicPU")
//    private EntityManager em;
//
//    public MembersBandFacadeREST() {
//        super(MembersBand.class);
//    }
//
//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(MembersBand entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") String id, MembersBand entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") String id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public MembersBand find(@PathParam("id") String id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<MiembrosBanda> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<MiembrosBanda> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
