package ve.leota.modelos;

public class Cliente {
    //Declaro los atributos del cliente
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;

    //Constructor
    public Cliente(){
    }

    //Inicializo los atributos
    public Cliente(String cedula, String nombre, String apellido, String direccion, String correo){
        super();
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.correo=correo;
    }

    //metodos get y set

    /*Cedula */
    public String getCedula(){
        return cedula;
    }

    public void setCedula(String cedula){
        this.cedula=cedula;
    }

    //Nombre
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    /*Apellido*/
    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    /*Direccion*/
    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    /*Correo*/
    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

}
