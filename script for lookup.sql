DECLARE
 XROW     ROWID;  --You cant directly give Row Id to the x_rowid parameter, 
ln_rowid1   ROWID;       
       cursor c is     select * from xx_dept; --My Custom Query to have fetch in my custom table
     cursor c1 is 
    select distinct lookup_type from xx_dept;
    BEGIN    
    for i in c1   -- For loop for Inserting lookup types     
    loop   
       fnd_lookup_types_pkg.insert_row (x_rowid                    => XROW,
                                        x_lookup_type              => i.lookup_type,  --cursor values
                                        x_security_group_id        => 0,
                                        x_view_application_id      => 3,
                                        x_application_id           => 20187,
                                        x_customization_level      => 'U',
                                        x_meaning                  => i.lookup_type,
                                        x_description              => i.lookup_type,
                                        x_creation_date            => SYSDATE,
                                        x_created_by               => 1318,
                                        x_last_update_date         => SYSDATE,
                                        x_last_updated_by          => 0,
                                        x_last_update_login        => 5513095
                                       );
      DBMS_OUTPUT.put_line (XROW);
      end loop;  --Loop ends here
   commit;
         for i in c -- For loop for Inserting lookup values
             loop   
       fnd_lookup_values_pkg.insert_row (x_rowid                    => ln_rowid1,
                                         x_lookup_type              => I.LOOKUP_TYPE,  --Secomd cursor values
                                         x_security_group_id        => 0,
                                         x_view_application_id      => 3,
                                         x_lookup_code              => I.LOOKUP_CODE, 
                                         x_tag                      => NULL,
                                         x_attribute_category       => NULL,
                                         x_attribute1               => NULL,
                                         x_attribute2               => NULL,
                                         x_attribute3               => NULL,
                                         x_attribute4               => NULL,
                                         x_enabled_flag             => 'Y',
                                         x_start_date_active        => TO_DATE ('01-JAN-1950',
                                                                                'DD-MON-YYYY'
                                                                               ),
                                         x_end_date_active          => NULL,
                                         x_territory_code           => NULL,
                                         x_attribute5               => NULL,
                                         x_attribute6               => NULL,
                                         x_attribute7               => NULL,
                                         x_attribute8               => NULL,
                                         x_attribute9               => NULL,
                                         x_attribute10              => NULL,
                                         x_attribute11              => NULL,
                                         x_attribute12              => NULL,
                                         x_attribute13              => NULL,
                                         x_attribute14              => NULL,
                                         x_attribute15              => NULL,
                                         x_meaning                  => I.LOOKUP_MEANING,
                                         x_description              => NULL,
                                         x_creation_date            => SYSDATE,
                                         x_created_by               => 1318,
                                         x_last_update_date         => SYSDATE,
                                         x_last_updated_by          => 1318,
                                         x_last_update_login        => 5513095
                                        );
       DBMS_OUTPUT.put_line (ln_rowid1);
       end loop;
       exception
       when others then dbms_output.put_line('Exception Occured');
commit;
    END;
    

    
    
select LOOKUP_TYPE, LOOKUP_CODE, MEANING from fnd_lookup_values where lookup_type='MOISS_DOC_DEPTS';    
    
select LOOKUP_TYPE, LOOKUP_CODE, MEANING from fnd_lookup_values where lookup_type='MOISS_DOC_CATEGORY';
    

select * from fnd_lookup_values where lookup_type like '%MOISS_DOC_DEPTS%';    
    
    
    
    
select * from fnd_lookup_values where lookup_type like '%MOISS%';