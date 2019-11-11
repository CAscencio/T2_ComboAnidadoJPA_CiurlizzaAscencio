package controller;

import modelo.entity.Provincia;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import modelo.dao.ProvinciaFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entity.Departamento;

@Named("provinciaController")
@SessionScoped
public class ProvinciaController implements Serializable {

    @EJB
    private modelo.dao.ProvinciaFacade ejbFacade;
    private List<Provincia> items = null;
    private List<Provincia> listaCombo;
    private Provincia selected;
    private Departamento departamento = new Departamento();

    public ProvinciaController() {
    }

    public Provincia getSelected() {
        return selected;
    }

    public void setSelected(Provincia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProvinciaFacade getFacade() {
        return ejbFacade;
    }

    public Provincia prepareCreate() {
        selected = new Provincia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Vista").getString("ProvinciaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Vista").getString("ProvinciaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Vista").getString("ProvinciaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Provincia> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vista").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vista").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Provincia> listaProvincia() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public Provincia getProvincia(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<Provincia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Provincia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Provincia.class)
    public static class ProvinciaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProvinciaController controller = (ProvinciaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "provinciaController");
            return controller.getProvincia(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Provincia) {
                Provincia o = (Provincia) object;
                return getStringKey(o.getCodprov());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Provincia.class.getName()});
                return null;
            }
        }

    }

    public List<Provincia> getListaCombo() {
        return listaCombo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    

    public List<Provincia> dataProvincia() {
        System.out.println("ENTRE AL METODO");
        listaCombo = new ArrayList();
        System.out.println("CODIGO :" +departamento.getCoddepart());
        listaCombo = getFacade().listaDepartamento(departamento.getCoddepart());
        System.out.println("DATOS :" +listaCombo.toString());
        return listaCombo;
    }

}
