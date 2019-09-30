/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pc
 */
@javax.ws.rs.ApplicationPath("espeMusic")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.ESPEmusic.model.service.AdministratorRecordMusicFacadeREST.class);
        resources.add(ec.edu.espe.ESPEmusic.model.service.AlbumFacadeREST.class);
        resources.add(ec.edu.espe.ESPEmusic.model.service.BandFacadeREST.class);
        resources.add(ec.edu.espe.ESPEmusic.model.service.SongFacadeREST.class);
        resources.add(ec.edu.espe.ESPEmusic.model.service.ManagerFacadeREST.class);
        resources.add(ec.edu.espe.ESPEmusic.model.service.MembersBandFacadeREST.class);
    }
    
}
