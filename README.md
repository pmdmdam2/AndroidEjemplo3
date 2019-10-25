# AndroidEjemplo3
Este ejemplo muestra tres widgets en un ConstraintLayout. Incluye además una barrera y una línea guía que se utilizan para mostrar para que se pueden utilizar en diseño. Además se incluye un grupo que incluye los dos EditText, uno de tipo fecha y otro de tipo hora. A continuación se describe el diseño de los widgets incluidos en el ConstraintLayout:

- EditText de tipo hora

<EditText

        android:id="@+id/etHora"
        //el valor 0dp en layout_width dentro de un ConstraintLayout significa match_constraint
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        //márgenes a la derecha y al final, tienen el mismo efecto ambos atributos ya que el 
        //diseño es de derecha a izquierda
        android:layout_marginEnd="84dp"
        android:layout_marginRight="84dp"
        //establece el ancho del EditText al tamaño de 10 m's
        android:ems="10"
        android:hint="@string/hora"
        //evita definir el atributo android:autofillHints
        android:importantForAutofill="no"
        //tipo de EditText
        android:inputType="time"
        //restricciones de diseño
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.306" 
/>

- EditText de tipo fecha

<EditText

        android:id="@+id/etFecha"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginEnd="84dp"
        android:layout_marginRight="84dp"
        android:ems="10"
        android:hint="@string/fecha"
        android:importantForAutofill="no"
        android:inputType="date"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.677" 
/>

- Barrera

<androidx.constraintlayout.widget.Barrier

        android:id="@+id/barrier"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        //margen desde el principio y margen izquierdo
        android:layout_marginStart="100dp"
        android:layout_marginLeft="100dp"
        //dirección de la barrera
        app:barrierDirection="left"
        //widgets limitados por la barrera
        app:constraint_referenced_ids="etHora,etFecha"
        //el punto de inicio de la barrera se coloca respecto del punto de inicio del ConstraintLayout
        app:layout_constraintStart_toStartOf="parent"
/>

- Grupo

<androidx.constraintlayout.widget.Group

        android:id="@+id/grMostrar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        //la visibilidad asignada inicialmente es GONE, los widgets incluidos en el grupo desaparecen 
        android:visibility="gone"
        //widgets incluidos en el grupo
        app:constraint_referenced_ids="etFecha,etHora" 
/>

- Switch

<Switch

        android:id="@+id/swMostrar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        //el switch inicialmente está OFF
        android:checked="false"
        android:text="@string/mostrar"
        //el borde inferior del switch se coloca por encima del borde izquierdo de la línea guía
        app:layout_constraintBottom_toTopOf="@+id/guideline"
        //el final del switch se coloca respecto del final del ConstraintLayout
        app:layout_constraintEnd_toEndOf="parent"
        //el comienzo del switch se coloca respecto del comienzo del ConstraintLayout
        app:layout_constraintStart_toStartOf="parent"
        //la parte superior del switch se coloca respecto de la parte superior del ConstraintLayout
        app:layout_constraintTop_toTopOf="parent" 
/>

- Línea guía

<androidx.constraintlayout.widget.Guideline

        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        //orientación horizontal de la línea guía
        android:orientation="horizontal"
        //posición de comienzo de la línea guía respecto del ConstraintLayout
        app:layout_constraintGuide_begin="79dp" 
/>

Hasta aquí la parte declarativa del proyecto, a continuación se muestra el código del método onCreate en el que se incluye una lógica para ocultar y mostrar los widgets que están dentro del grupo, utilizando para ello un Switch.

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch swMostrar = findViewById(R.id.swMostrar);
        final Group grMostrar = findViewById(R.id.grMostrar);

        swMostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    grMostrar.setVisibility(View.VISIBLE);
                else
                    grMostrar.setVisibility(View.GONE);
            }
        });
    }
