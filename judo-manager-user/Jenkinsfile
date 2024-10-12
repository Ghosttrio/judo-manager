import java.text.SimpleDateFormat
import java.util.TimeZone
import java.math.BigDecimal


pipeline {
    agent any

    parameters {
        choice(
            name: 'MODULE',
            choices: ['ALL'],
            description: '모듈 선택하기'
        )
    }

    stages {

        stage('CLONE') {
            steps {
                script{
                    def ref = "$ref"
                    def st = ref.split('/')
                    def currentBranch = st[st.size()-1]
                    def buildGradle = readFile('build.gradle')
                    def versionLine = buildGradle.readLines().find { it.trim().startsWith("version") }
                    def version = versionLine.replaceAll(/version\s*=\s*['"]/, '').replaceAll(/['"]/, '').trim()
                    def currentVersion = "${version}"
                    def seoulTimeZone = TimeZone.getTimeZone("Asia/Seoul")
                    def currentTime = new Date()
                    def sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    sdf.setTimeZone(seoulTimeZone)
                    def message = "${sdf.format(currentTime)}"

                    slackSend (
                        channel: '#일반',
                        color: '#FFFF00',
                        message: "Production 배포 시작: ["+ currentVersion +"] PROD-" + params.MODULE + " module (" + message + ")"
                    )

                    git branch: "$currentBranch",
                    credentialsId: 'gitHub-token',
                    url: ''
                }
            }
        }

        stage('BUILD'){
            steps{
                script{
                    sh 'chmod +x gradlew'
                    if (params.MODULE == '') {
                        sh './gradlew judo-manager-api:clean judo-manager-api:build'
                        sh '''
                            cd api
                            docker build
                            docker push
                        '''
                    }else {
                        error "Invalid module selected"
                    }
                }
            }
        }

        stage('DEPLOY') {
            steps {
                script{
                    if (params.MODULE == 'API') {
                        sshPublisher(
                            publishers: [
                                sshPublisherDesc(
                                    configName: 'judo-manager-api',
                                    transfers: [
                                        sshTransfer(
                                            cleanRemote: false,
                                            excludes: '',
                                            execCommand: '''
                                                docker pull

                                                docker ps -q --filter name=judo-manager-api | grep -q . && docker rm -f $(docker ps -aq --filter name=judo-manager-api)

                                                docker run -d --name=judo-manager-api -p 80:8080 -p 2023:2023 -e TZ=Asia/Seoul --env JASYPT_PASSWORD=ghosttrio123 ghosttrio/judo-manager-api:latest

                                            ''',
                                            execTimeout: 120000,
                                            flatten: false,
                                             makeEmptyDirs: false,
                                             noDefaultExcludes: false,
                                             patternSeparator: '[, ]+',
                                             remoteDirectory: '',
                                             remoteDirectorySDF: false,
                                             removePrefix: '',
                                             sourceFiles: '**/*.jar'
                                             )
                                         ],
                                         usePromotionTimestamp: false,
                                         useWorkspaceInPromotion: false,
                                         verbose: false
                                     )
                                 ]
                             )
                    } else {
                        error "Invalid module selected"
                    }
                }
            }
        }
    }
    post {
         success {
            script{
               def buildGradle = readFile('build.gradle')
               def versionLine = buildGradle.readLines().find { it.trim().startsWith("version") }
               def version = versionLine.replaceAll(/version\s*=\s*['"]/, '').replaceAll(/['"]/, '').trim()
               def currentVersion = "${version}"

               def seoulTimeZone = TimeZone.getTimeZone("Asia/Seoul")
               def currentTime = new Date()
               def sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
               sdf.setTimeZone(seoulTimeZone)
               def message = "${sdf.format(currentTime)}"

               slackSend (
                   channel: '#일반',
                   color: '#00FF00',
                   message: '배포 성공: ['+currentVersion+'] PROD-'+params.MODULE+' module (' + message + ')'
               )
            }
         }
         failure {
             script{
                def buildGradle = readFile('build.gradle')
                def versionLine = buildGradle.readLines().find { it.trim().startsWith("version") }
                def version = versionLine.replaceAll(/version\s*=\s*['"]/, '').replaceAll(/['"]/, '').trim()
                def currentVersion = "${version}"
                def seoulTimeZone = TimeZone.getTimeZone("Asia/Seoul")
                def currentTime = new Date()
                def sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                sdf.setTimeZone(seoulTimeZone)
                def message = "${sdf.format(currentTime)}"

                slackSend (
                    channel: '#일반',
                    color: '#FF0000',
                    message: "배포 실패: [" + currentVersion + "] PROD-"+params.MODULE+" module (" + message + ")"
                )
             }
         }
    }
}