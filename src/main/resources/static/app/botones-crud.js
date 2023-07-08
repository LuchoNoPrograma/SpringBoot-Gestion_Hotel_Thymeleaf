$('.btn-eliminar').on('click', function (e) {
  e.preventDefault();
  Swal.fire({
    icon: 'warning',
    title: 'Estas seguro?',
    text: 'El registro sera eliminado!',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, eliminar!',
    cancelButtonText: 'Cancelar'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire({
        title: 'El formulario esta siendo procesado',
        text: 'Por favor, espere...',
        allowOutsideClick: false,
        showConfirmButton: false,
        onBeforeOpen: () => {
          Swal.showLoading();
          $(this).closest('form').submit()
        }
      });
    }
  })
})

function alertaEnviarFormulario(config) {
  let {selector, tipoEvento,titulo, textoAlerta, textoBoton} = config;
  $($(selector)).on(tipoEvento, function (e) {
    e.preventDefault();
    Swal.fire({
      title: titulo,
      text: textoAlerta,
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: textoBoton,
      cancelButtonText: 'Cancelar',
      customClass: {
        confirmButton: 'bg-primary',
        cancelButton: 'bg-danger'
      },
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire({
          title: 'El formulario esta siendo procesado',
          text: 'Por favor, espere...',
          allowOutsideClick: false,
          showConfirmButton: false,
          onBeforeOpen: () => {
            Swal.showLoading();
            $(this).closest('form').submit();
          }
        });
      }
    });
  });
}

function alertaConfirmar(config) {
  let {selector, tipoEvento,titulo, textoAlerta, textoBoton} = config;
  $($(selector)).on(tipoEvento, function (e) {
    e.preventDefault();
    Swal.fire({
      title: titulo,
      text: textoAlerta,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: textoBoton,
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire({
          title: 'El formulario esta siendo procesado',
          text: 'Por favor, espere...',
          allowOutsideClick: false,
          showConfirmButton: false,
          onBeforeOpen: () => {
            Swal.showLoading();
            $(this).closest('form').submit();
          }
        });
      }
    });
  })
}