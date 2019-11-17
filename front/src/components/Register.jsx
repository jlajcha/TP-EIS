import React    from "react";
import {register} from "../Api";
import {addPet} from "../Api";
import                  '../css/loginStyles.css';
import                  '../css/popupStyeles.css';

/************************************ Componente PopUp *************************************/

class Popup extends React.Component {

    constructor(props){
        super(props);
    }

    render() {
        return (
            <div className='popup'>
                <div className='popup_inner'>
                    {this.props.form}
                </div>
            </div>
        );
        }
  }


  /***********************************************************************************************/

export default class Register  extends React.Component{

    constructor(props) {
        super(props);

        this.state = {
                firstName: '',
                lastName: '',
                dni:'',
                tel: '',
                address: '',
                mail:'',
                pets: [],
                showPopup: false,
                petName: '',
                notes: '',
                    };
        
        this.changeFirstName = this.changeFirstName.bind(this);
        this.changeLastName = this.changeLastName.bind(this);
        this.changeDni = this.changeDni.bind(this);
        this.changeTel = this.changeTel.bind(this);
        this.changeAddress = this.changeAddress.bind(this);
        this.changeMail = this.changeMail.bind(this);
        this.register = this.register.bind(this)

        this.togglePopup = this.togglePopup.bind(this);   

        this.changeNameAnimal = this.changeNameAnimal.bind(this);
        this.changeNotes = this.changeNotes.bind(this);
        this.changeDniOwner = this.changeDniOwner.bind(this)
    }

    changeFirstName(event){
        this.setState( {firstName: event.target.value} )        
    }
    changeLastName(event){
        this.setState( {lastName: event.target.value} )
    }
    changeDni(event){
        this.setState( {dni: event.target.value} )
    }
    changeTel(event){
        this.setState( {tel: event.target.value} )
    }
    changeAddress(event){
        this.setState( {address: event.target.value} )
    }
    changeMail(event){
        this.setState( {mail: event.target.value} )
    }

    changeNameAnimal(event){
        this.setState( {petName: event.target.value} )
    }

    changeDniOwner(event){
        this.setState( {dni: event.target.value} )
    }

    changeNotes(event){
        this.setState( {notes: event.target.value} )
    }

    register() {
          const body = {
            dni : this.state.dni,
            name: this.state.firstName,
            surname: this.state.lastName,
            address: this.state.address,
            email: this.state.mail,
            telephone: this.state.tel,
          };
          register(body)
            .then(() => this.setState({ toHome: true }))
            .catch(() => this.setState({ error: 'Usuario ya utilizado' }));  
        }


      
    addPets(){
        const body = {
            petName: this.state.petName,
            ownerDni: this.state.dni,
            notes: this.state.notes,
        };
        addPet(body)
            .then(() => this.setState({ toHome: true }))
            .catch(() => this.setState({ error: 'Usuario ya utilizado' })); 
    }

    /********************************* Manipulación del Pop-Up ********************************/

    createContentPopUp(){
        return (
            <div className=''>
              {this.state.showPopup ? 
                <Popup
                  form={this.createRegistrationPet()}
                />
                : null
              }
            </div>
          );
    }

    createRegistrationPet(){
        return (
            <div>
                <form className="formPet">
                    <p>Nueva mascota</p>
                    <div className="rowfilds">
                        <input type="text" name="namePet" className="fieldForm " placeholder="Nombre del animal" value={this.state.petName} onChange={this.changeNameAnimal}/>                     
                        <input type="text" name ="lastName" className = "fieldForm"  placeholder="DNI del dueño" value={this.state.dni} onChange={this.changeDniOwner}/>      
                    </div>
                    <textarea className="notes" name="notes" rows="6" cols="50" placeholder="Historia clínica" onChange={this.changeNotes}></textarea> 
                    <div className="rowfilds">
                        <button onClick={() => this.togglePopup()}>Cancelar</button>
                        <button type = "button" className = "savePet" onClick ={ () => this.addPets() }>Guardar </button>
                    </div>
                        
                </form>
            </div>
        );
    }

   
    togglePopup(event) {
        this.setState({ showPopup: event });
   }


    /**********************************************************************************************/

    render(){
        
        return(
                <div className="containerForm">
                    <form  className="formRegister">
                        <p className="titleForm">Registrar cliente</p>
                        <div className="rowfilds">
                            <input type="text" name="firstName" className="fieldForm "  value={this.state.firstName} onChange={this.changeFirstName} placeholder="Nombre"/>                     
                            <input type="text" name ="lastName" className = "fieldForm"  value={this.state.lastName} onChange={this.changeLastName} placeholder="Apellido"/>          
                        </div>
                        <div className="rowfilds">
                            <input type="text" name ="dni"  className="fieldForm" value={this.state.dni} onChange={this.changeDni} placeholder="DNI"/> 
                            <input type="text" name ="tel" className="fieldForm" value={this.state.tel} onChange={this.changeTel} placeholder="Tel."/>
                            </div>
                        <div className="rowfilds">
                            <input type="text" name ="address" className="fieldForm" value={this.state.address} onChange={this.changeAddress} placeholder="Domicilio"/>
                            <input type="text" name ="mail" className="fieldForm" value={this.state.mail} onChange={this.changeMail} placeholder="Mail"/>
                        </div>
                        <p className="titleForm mascotas">Mascotas</p>
                        <div className="containerPet">
                            {this.createContentPopUp()}
                            <button type="button" className="addPet" onClick={() => this.togglePopup(!this.state.showPopup)}>Agregar</button>
                        </div>
                        <button type = "button" className = "" onClick={() => this.register }>Registrar </button>
                    </form>
                </div>
            
        );
    }
}
