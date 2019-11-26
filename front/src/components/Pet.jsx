
import React from 'react';

import                  '../css/loginStyles.css';
import                  '../css/popupStyeles.css';

export default class  PetCard extends React.Component{
    constructor(props){
        super(props);
        
    };


render(){

const renderPet =   <li className="bicho" key={this.props.petCode}>
        
    <div className="container2" >
        <div class="row">
            
            <div class="col-sm d-flex">
              <div class="card card-body flex-fill">
                    <div className="card-body text-primary">
                            <h5 className="card-title">
                                <p>Nombre: {this.props.petName}</p>
                            </h5>
                            <h6>
                                <p> Notas: {this.props.petNotes}  </p>
                            </h6>
                            </div>
                        </div>
                    </div>
                </div>
               </div>      
            </li>

    return(
        <div>{renderPet}</div>
    );
 }
}