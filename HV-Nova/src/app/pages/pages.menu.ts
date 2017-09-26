export const PAGES_MENU = [
  {
    path: 'pages',
    children: [
      {
        path: 'dashboard',
        data: {
          menu: {
            title: 'Tablero',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      },
  
      {
        path: 'accountmanagement',
        data: {
          menu: {
            title: 'Datos Clientes',
            icon: 'ion-compose',
            selected: false,
            expanded: false,
            order: 300,
          }
        },
        children: [
          {
            path: 'generaldata',
            data: {
              menu: {
                title: 'Generales',
              }
            }
          },
          {
            path: 'headquarters',
            data: {
              menu: {
                title: 'Sedes',
              }
            }
          },
          {
            path: 'businessdata',
            data: {
              menu: {
                title: 'Negocio',
              }
            }
          },
          {
            path: 'contacts',
            data: {
              menu: {
                title: 'Contactos',
              }
            }
          },
          {
            path: 'servicelevels',
            data: {
              menu: {
                title: 'Niveles de Servicio',
              }
            }
          },
          {
            path: 'opposition',
            data: {
              menu: {
                title: 'Competencia',
              }
            }
          },
         
        ]
      },

      {
        path: 'users',
        data: {
          menu: {
            title: 'Usuarios',
            icon: 'ion-ios-person-outline',
            selected: false,
            expanded: false,
            order: 600,
          }
        },
        children: [
          {
            path: 'newuser',
            data: {
              menu: {
                title: 'Crear usuario',
              }
            }
          },
          {
            path: 'viewusers',
            data: {
              menu: {
                title: 'Listar Usuarios',
              }
            }
          },      
        ]
      },

      {
        path: 'dynamicreports',
        data: {
          menu: {
            title: 'Reportes',
            icon: 'ion-ios-paper-outline',
            selected: false,
            expanded: false,
            order: 500,
          }
        },
        children: [
          {
            path: 'reports',
            data: {
              menu: {
                title: 'Reportes',
              }
            }
          },
        ]
      },
      {
        path: '',
        data: {
          menu: {
            title: 'Configuración',
            icon: 'ion-ios-gear-outline',
            selected: false,
            expanded: false,
            order: 650,
          }
        },
        children: [
          {
            path: ['/login'],
            data: {
              menu: {
                title: 'general.menu.login'
              }
            }
          },
          {
            path: ['/register'],
            data: {
              menu: {
                title: 'general.menu.register'
              }
            }
          }
        ]
      },
     
  
    ]
  }
];
