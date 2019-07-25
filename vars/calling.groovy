def call(){
  def buser=wrap([$class: 'BuildUser']) {
                    return env.BUILD_USER
                    }
  echo "Inside Library function: ${buser}"
}
