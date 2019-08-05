def call(buser){
  /*def buser=wrap([$class: 'BuildUser']) {
                    return env.BUILD_USER
                    }*/
  def gitcommit=''
  echo "Inside Library function: ${buser}"
  if(env.GIT_URL.contains("https://"))
  {
   gitcommit=env.GIT_URL.replace('.git','/')+"commit/"+env.GIT_COMMIT   
  }
  else
  {
   gitcommit="https://"+env.GIT_URL.split('@')[1].replace(':','/').replace('.git','/')+"commit/"+env.GIT_COMMIT  
  }
  return gitcommit
}
