function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    myVarName: 'someValue'
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env == 'e2e') {
    // customize
  }

   //var config = { myprop: 'myvalue', myurl: 'somevalue' };
   //var accesToken = karate.callSingle('classpath:helpers/users.feature', config).authToken
   //karate.configure('headers', {Authorization: 'Token ' + accesToken, Accept: 'application/json' })

  return config;
}