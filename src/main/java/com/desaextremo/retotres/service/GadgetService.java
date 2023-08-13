package com.desaextremo.retotres.service;

import com.desaextremo.retotres.entity.Gadget;
import com.desaextremo.retotres.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository repositorio;

    public List<Gadget> getAll(){
        return repositorio.findAll();
    }

    public Gadget getGadget(Integer id){
        Optional<Gadget> optional = repositorio.findById(id);

        if(optional.isPresent()) return optional.get();
        else return new Gadget();
    }

    public Gadget registrar(Gadget gadget) {
        Gadget gadgetError;

        if (gadget.getId() != null) {
            //si el id ya existe
            Optional<Gadget> optional = repositorio.findById(gadget.getId());

            if (optional.isPresent()){
                gadgetError = new Gadget();
                gadgetError.setName("ID " + gadget.getId() + " YA EXISTE");
                return gadgetError;
            }else return repositorio.save(gadget);
        } else {
            gadgetError = new Gadget();
            gadgetError.setName("FALTA EL ID");
            return gadgetError;
        }
    }
    public Gadget actualizar(Gadget gadget) {
        Gadget gadgetError;

        if (gadget.getId() != null) {
            Optional<Gadget> gadgetDb = repositorio.findById(gadget.getId());
            if (!gadgetDb.isEmpty()) {
                if (gadget.getName() != null) {
                    gadgetDb.get().setName(gadget.getName());
                }
                if (gadget.getBrand()!= null) {
                    gadgetDb.get().setBrand(gadget.getBrand());
                }
                if (gadget.getCategory() != null) {
                    gadgetDb.get().setCategory(gadget.getCategory());
                }
                if (gadget.getDescription() != null) {
                    gadgetDb.get().setDescription(gadget.getDescription());
                }
                if (gadget.getQuantity() != 0) {
                    gadgetDb.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPrice() != 0.0) {
                    gadgetDb.get().setPrice(gadget.getPrice());
                }
                if (gadget.getPhotography()!= null) {
                    gadgetDb.get().setPhotography(gadget.getPhotography());
                }

                repositorio.save(gadgetDb.get());
                return gadgetDb.get();
            } else {
                gadgetError = new Gadget();
                gadgetError.setName("No existe un usuario con el ID " + gadgetError.getId());
                return gadgetError;
            }
        } else {
            gadgetError = new Gadget();
            gadgetError.setName("No se envio un valor para el ID");
            return gadgetError;
        }
    }

    public boolean delete(int id) {
        Gadget gadgetDelete;
        Optional<Gadget> optional = repositorio.findById(id);

        if (optional.isPresent()){
            gadgetDelete = optional.get();
            repositorio.delete(gadgetDelete);
            return true;
        }else{
            return false;
        }
    }
}
